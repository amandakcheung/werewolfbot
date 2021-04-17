from discord.ext import commands
import discord
import os
import random

client = discord.Client()
bot = commands.Bot(command_prefix='$')


#adds the number of players and makes an array of them
def createRoles(numPlayers):
  if numPlayers <= 7:
    return "Sorry there are not enough players."

  if numPlayers == 8:
    wolves = ["Snow Wolf", "King Wolf"]
    listofRoles = ["town", "town"]
    numW = random.randint(0,1)
    listofRoles.append(wolves[numW])
    listofRoles.append("wolf");
    listofRoles.append("wolf");
    special = ["Doctor/Witch", "Seer", "Knight/Rider", "Hunter"]
    i = 4
    while (i > 1):
      numS = random.randint(0,i-1)
      listofRoles.append(special[numS])
      special.remove(numS)
      i-=1
    return listofRoles

  if numPlayers == 9:
    wolves = ["Snow Wolf", "King Wolf"]
    listofRoles = ["town", "town"", town"]
    numW = random.randint(0,1)
    listofRoles.append(wolves[numW])
    listofRoles.append("wolf");
    listofRoles.append("wolf");
    special = ["Doctor/Witch", "Seer", "Knight/Rider", "Hunter"]
    i = 4
    while (i > 1):
      numS = random.randint(0,i-1)
      listofRoles.append(special[numS])
      special.remove(numS)
      i-=1
    return listofRoles

  if numPlayers == 10:
    wolves = ["Snow Wolf", "King Wolf"]
    listofRoles = ["Doctor/Witch", "Seer", "Knight/Rider", "Hunter", "town", "town", "town"]
    numW = random.randint(0,1)
    listofRoles.append(wolves[numW])
    listofRoles.append("wolf");
    listofRoles.append("wolf");
    return listofRoles

  if numPlayers == 11:
    listofRoles = ["Snow Wolf", "King Wolf", "Wolf", "Doctor/Witch", "Seer", "Knight/Rider", "Hunter", "town", "town", "town", "town"]
    return listofRoles


  if numPlayers == 12:
    listofRoles = ["Snow Wolf", "King Wolf", "Wolf", "Wolf", "Doctor/Witch", "Seer", "Knight/Rider", "Hunter", "town", "town", "town", "town"]
    return listofRoles

@client.event
async def on_ready():
    print('We have logged in as {0.user}'.format(client))

#checks the channel to see number of players 
@client.event
async def on_message(message):
    if message.author == client.user:
      return 

    if message.content.startswith('seer'):
      await message.channel.send('they are')

    if message.content.startswith('7'):
        await message.channel.send('Sorry, there are not enough people to play!')
        numPlayers = 7
        return numPlayers
    
    if message.content.startswith('start 8'):
      #creates the array of characters being played
        numReactions = []
        numPlayers = 8
        wolves = ["Snow Wolf", "King Wolf"]
        listofRoles = ["town", "town"]
        numW = random.randint(0,1)
        listofRoles.append(wolves[numW])
        listofRoles.append("wolf")
        listofRoles.append("wolf")
        special = ["Doctor/Witch", "Seer", "Knight/Rider", "Hunter"]
        i = 4
        #randomly assigns them 
        while (i > 1):
            numS = random.randint(0,i-1)
            listofRoles.append(special[numS])
            special.remove(special[numS])
            i-=1
        numR = random.randint(0,len(listofRoles))
        randlistofRoles = []
        for role in listofRoles:
          currentRole = listofRoles[numR]
          randlistofRoles.append(currentRole)
          randlistofRoles.remove(currentRole)
          #sends a message, and if reacted to, will send a role to players
        channel = message.channel
        await channel.send('React with the 👍 to play!')
        def check(reaction, user):
            return user == message.author and str(reaction.emoji) == '👍'
        try:
            reaction, user = await client.wait_for('reaction_add', timeout=60.0, check=check)
        except asyncio.TimeoutError:
            await channel.send('👎')
        else:
          await message.author.send("You are: " + listofRoles[numR])

          """ numReactions.append(message.author.id)
          while len(numReactions) < 1:
                await message.author.send("waiting for more players")
          #i = 7
          while i >= 0:
            for author in randlistofRoles:
              await message.author.send("You are: " + randlistofRoles[i])
              #i-=1 """

    if message.content.startswith('start 9'):
        numReactions = []
        numPlayers = 9
        wolves = ["Snow Wolf", "King Wolf"]
        listofRoles = ["town", "town"", town"]
        numW = random.randint(0,1)
        listofRoles.append(wolves[numW])
        listofRoles.append("wolf")
        listofRoles.append("wolf")
        specials = ["Doctor/Witch", "Seer", "Knight/Rider", "Hunter"]
        i = 4
        while (i > 1):
            numS = random.randint(0,i-1)
            listofRoles.append(specials[numS])
            specials.remove(specials[numS])
            i-=1

        numR = random.randint(0,len(listofRoles))
        randlistofRoles = []
        for role in listofRoles:
          currentRole = listofRoles[numR]
          randlistofRoles.append(currentRole)
          randlistofRoles.remove(currentRole)
        channel = message.channel
        await channel.send('React with the 👍 to play!')
        def check1(reaction, user):
            return user == message.author and str(reaction.emoji) == '👍'
        try:
            reaction, user = await client.wait_for('reaction_add', timeout=60.0, check=check)
        except asyncio.TimeoutError:
            await channel.send('👎')
        else:
            numReactions.append(ctx.message.author.id)
            while len(numReactions) < 1:
                  await message.author.send("waiting for more players")
            for player in numReactions:
              await message.player.send("You are: " + randlistofRoles)
client.run('TOKEN')

